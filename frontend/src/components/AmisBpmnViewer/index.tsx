import React, {FunctionComponent, useEffect, useRef, useState} from 'react';
import {Renderer} from 'amis';
import BpmnViewer from 'bpmn-js/lib/Viewer';
import {RendererProps, RendererComponent} from 'amis-core/lib/factory';
import styles from './index.less';

interface BpmnProps extends RendererProps {
  height: number; // svg 高度
  data: {
    xml: string; // xml 内容
    activities: Array<any>; // 后端返回的 activities 工作流
  };
}

const bpmn: RendererComponent = React.forwardRef((props: BpmnProps, ref) => {
  const canvasRef = useRef(null);
  const [viewer, setViewer] = useState<Record<string, any>>({});

  const createNewDiagram = async (
    viewer: Record<string, any>,
    xml: string,
    activities: Array<Record<string, any>>,
  ) => {
    viewer.importXML(xml, function (err: any) {
      if (err) {
        console.log('error rendering', err);
      } else {
        const activities2Id: Record<string, unknown> = {};
        activities.filter((i) => i.activityType !== "sequenceFlow")
          .reduce((acc, cur) => {
            acc[cur.activityId] = cur;
            return acc;
          }, activities2Id);

        const sequenceFlowIds: Record<string, unknown> = {};
        activities.filter((i) => i.activityType === "sequenceFlow")
          .reduce((acc, cur) => {
            acc[cur.activityId] = cur;
            return acc;
          }, sequenceFlowIds);
        //自适应屏幕
        const canvas = viewer.get('canvas');
        canvas.zoom('fit-viewport', 'auto');
        viewer.definitions.rootElements[0].flowElements.forEach(
          (item: { id: any }) => {
            if (activities2Id[item.id] || sequenceFlowIds[item.id]) {
              canvas.addMarker(item, 'highlight');
            } else {
              canvas.addMarker(item, 'highlight-todo');
            }
          },
        );
      }
    });

    return viewer;
  };
  useEffect(() => {
    if (canvasRef.current) {
      const ins = new BpmnViewer({
        container: canvasRef.current,
        height: props.height,
      });

      setViewer(ins);
    }
  }, []);

  useEffect(() => {
    props.data.xml &&
    createNewDiagram(viewer, props.data.xml, props.data.activities);
  }, [viewer, props.data.xml, props.data.activities]);

  return (
    <div className={styles.ops_bpmn_viewer}>
      <div ref={canvasRef} className={styles.ops_bpmn_viewer__canvas}></div>
    </div>
  );
});

const wrapBpmn = Renderer({
  test: /bpmn-viewer/,
  name: 'bpmn-viewer',
})(bpmn);

import React, { useEffect, useRef } from 'react';
import { Row, Col } from 'antd';
import { PauseOutlined, RightOutlined, LeftOutlined } from '@ant-design/icons';
import styles from './index.less';
import { useModel } from '@umijs/max';
// import debounce from 'lodash/debounce';

const minWidth = 200;
const maxWidth = 500;

const ReSizer: React.FC = (props) => {
  const { collapsible, handleCollapsible, setSiderWidth, siderRef } =
    useModel('sider');
  const reSizerRef = useRef(null);

  const refWidth = useRef(200);
  const setRefWidth = (num: number) => (refWidth.current = num);
  const startX = useRef(0);
  const setStartX = (num: number) => (startX.current = num);
  const endX = useRef(0);
  const setEndX = (num: number) => (endX.current = num);

  useEffect(() => {
    if (!collapsible) {
      addEvent();
    } else {
      removeEvent();
    }
    return removeEvent;
  }, [collapsible]);

  const addEvent = () => {
    document.addEventListener('mousedown', handleMouseDown);
    document.addEventListener('mousemove', handleMouseMove);
  };

  const removeEvent = () => {
    document.removeEventListener('mousedown', handleMouseDown);
    document.removeEventListener('mousemove', handleMouseMove);
    document.removeEventListener('mousemove', handleMouseUp);
  };

  const handleMouseDown = (event) => {
    if (event.target === reSizerRef.current) {
      setStartX(event.pageX);
      document.addEventListener('mouseup', handleMouseUp);

      const { width } = window.getComputedStyle(siderRef.current);
      setRefWidth(parseFloat(width));
    }
  };

  const handleMouseMove = (event) => {
    if (startX.current) {
      event.preventDefault();
      setEndX(event.pageX);
      handleResizeElement();
    }
  };

  const handleResizeElement = () => {
    // let resizeWidth = siderWidth + endX.current - startX.current;
    let resizeWidth = refWidth.current + endX.current - startX.current;
    if (resizeWidth < minWidth) return;
    if (resizeWidth > maxWidth) return;

    // setSiderWidth(resizeWidth);

    const resizeWidthPx = resizeWidth + 'px';
    siderRef.current.style.width = resizeWidthPx;
    // siderRef.current.style.flex = `0 0 ${resizeWidthPx}`;
    // siderRef.current.style.maxWidth = resizeWidthPx;
  };

  const handleMouseUp = () => {
    // 防止每次触发mouseup
    setStartX(0);
    document.removeEventListener('mouseup', handleMouseUp);
  };

  return (
    <Row
      justify="center"
      align="middle"
      className={styles.resizer}
      ref={reSizerRef}
    >
      <Col className={styles['resizer-clip']}>
        <PauseOutlined />
      </Col>
      <Col onClick={handleCollapsible} className={styles['resizer-btn']}>
        {collapsible ? <RightOutlined /> : <LeftOutlined />}
      </Col>
      <Col className={styles['resizer-clip']}>
        <PauseOutlined />
      </Col>
    </Row>
  );
};

export default ReSizer;

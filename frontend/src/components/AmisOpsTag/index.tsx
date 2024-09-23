import React from 'react';
import { Renderer } from 'amis';
import { RendererProps, RendererComponent } from 'amis-core/lib/factory';
import styles from './index.module.css';

interface OpsTagProps extends RendererProps {
  value: string | number;
  map: { [propName: string]: { label: string; color: string } };
}

const opsTag: RendererComponent = React.forwardRef(
  (props: OpsTagProps, ref) => {
    let tagClassName = styles.default_tag;

    if (!props.map) return <span className={tagClassName}>{props.value}</span>;

    const hasColor = props.map[props.value]?.color;
    if (hasColor) {
      tagClassName += ` ${styles.has_color}`;
    }

    const tagStyle = {
      backgroundColor: props.map[props.value]?.color || '#fafafa',
    };

    const tagLabel = props.map[props.value]?.label || props.value;

    return (
      <span className={tagClassName} style={tagStyle}>
        {tagLabel}
      </span>
    );
  },
);

const wrapOpsTag = Renderer({
  test: /opsTag/,
  name: 'opsTag',
})(opsTag);

import React from 'react';
import { Renderer } from 'amis';
import { Link } from '@umijs/max';
import { Button } from 'antd';
import { RendererProps, RendererComponent } from 'amis-core/lib/factory';

interface LinkButtonProps extends RendererProps {
  label: 'string';
  link: 'string';
  blank?: Boolean;
}

const linkButton: RendererComponent = React.forwardRef(
  (props: LinkButtonProps, ref) => {
    const link =
      props.link
        .replace?.(/(?<=\${)\w*?(?=})/g, (match) => props.data[match] || '')
        .replaceAll('${', '')
        .replaceAll('}', '')
        .replace(/(?<=\$)\w*/g, (match) => props.data[match] || '')
        .replaceAll('$', '') || '';
    return (
      <Button size="small" key={props.label + props.link} className="mx-1 mb-1">
        <Link to={link}>{props.label}</Link>
      </Button>
    );
  },
);

const wraplinkButton = Renderer({
  test: /opsLinkButton/,
  name: 'opsLinkButton',
})(linkButton);

import { useState, useRef } from 'react';
export default function useSiderModels() {
  const [collapsible, setCollapsible] = useState(false);
  const [siderWidth, setSiderWidth] = useState(200);
  const siderRef = useRef(null);

  const handleCollapsible = () => {
    setCollapsible(!collapsible);
  };

  return {
    collapsible,
    handleCollapsible,
    siderWidth,
    setSiderWidth,
    siderRef,
  };
}

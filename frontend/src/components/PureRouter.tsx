import React, { FC } from 'react';
import { Outlet } from '@umijs/max';
import '@/components/AmisBpmnViewer/index';
import '@/components/AmisLinkButton/index';

const Index: FC = (props) => <><Outlet /></>;

export default Index;

import {Spin} from 'antd';
import React from 'react';

const App: React.FC = () => {
  const spinStyle = {
    margin: '20px 0',
    marginBottom: '20px',
    padding: '30px 50px',
    textAlign: 'center',
    background: 'rgba(0, 0, 0, 0)',
    borderRadius: '4px',
  } as React.CSSProperties;

  return (
    <div style={{display: 'flex', flexDirection: 'column', justifyContent: 'center', alignItems: 'center'}}>
      {/*<div style={{background: '#fff', height: '15px',width:'100%'}}>*/}
      {/*</div>*/}
      <div style={spinStyle}>
        <Spin/>
      </div>
    </div>
  )
};

export default App;


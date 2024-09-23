import React, { FC } from 'react';
import image from './images/avatar.png';
import background from './images/500.png';

const Custom: FC = (props) => {
  return (
    <>
      <img style={{ width: 300, height: 300 }} src={image}></img>
      <div
        style={{
          backgroundImage: `url(${background})`,
          width: 300,
          height: 300,
        }}
      >
        this is a picture
      </div>
    </>
  );
};

export default Custom;

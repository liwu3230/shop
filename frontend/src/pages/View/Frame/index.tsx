import React, {useEffect} from 'react';
import {history} from '@umijs/max';
import {useQuery} from '@/utils';
import {BASE_FRONT_ROUTE_PREFIX} from '@/constants';

const Frame: React.FC = (props) => {
    // const [iFrameHeight, setIframeHeight] = useState('100%');
    const link = decodeURIComponent(useQuery()?.link);
    useEffect(() => {
        if (!link) history.push(`${BASE_FRONT_ROUTE_PREFIX}/404`);
    }, [link]);
    return (
        <iframe
            id="micro-frame"
            style={{
                width: '100%',
                height: 'calc(100vh - 52px)',
                overflow: 'visible',
                border: 0,
            }}
            // onLoad={() => {
            //     const frameDoc = document.getElementById('micro-frame');
            //     if(frameDoc) setIframeHeight(frameDoc.clientHeight + 'px');
            // }}
            src={link}
            width="100%"
            // height={iFrameHeight}
            // scrolling="no"
        />
    );
};
export default Frame;

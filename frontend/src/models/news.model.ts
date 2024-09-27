import {useCallback, useEffect, useRef, useState} from 'react';
import {getNewsList} from '@/api/common';

export default function useNewsModel() {

  const [newsList, setNewsList] = useState([]);
  const timerRef = useRef(null);
  useEffect(() => {
    getNewsList().then((res) => {
      if (res.code === 0) setNewsList(res.data);
    });
    if (timerRef.current) {
      clearInterval(timerRef.current);
    }
    timerRef.current = setInterval(() => getNewsList().then((res) => {
      if (res.code === 0) setNewsList(res.data);
    }), 30000);
    return () => {
      clearInterval(timerRef.current);
    }
  }, []);

  const fetchNewsList = useCallback(async () => {
    const {data} = await getNewsList();
    setNewsList(data);
  }, []);


  return {
    newsList,
    fetchNewsList,
    setNewsList,
  };
}

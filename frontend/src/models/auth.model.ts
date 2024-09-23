import {useCallback, useEffect, useRef, useState} from 'react';
import {getButtonPermission, getCurrentUser, getTodoCount} from '@/api/common';

export default function useAuthModel() {

  const [permissionList, setPermissionList] = useState([]);
  useEffect(() => {
    getButtonPermission().then((res) => {
      if (res.code === 0) setPermissionList(res.data);
    });
  }, []);
  const fetchPermissionList = useCallback(async () => {
    const {data} = await getButtonPermission();
    setPermissionList(data);
  }, []);

  const [currentUser, setCurrentUser] = useState([]);
  useEffect(() => {
    getCurrentUser().then((res) => {
      if (res.code === 0) setCurrentUser(res.data);
    });
  }, []);

  const fetchCurrentUser = useCallback(async () => {
    const {data} = await getCurrentUser();
    setCurrentUser(data);
  }, []);

  const [todoCount, setTodoCount] = useState([]);
  const timerRef = useRef(null);
  useEffect(() => {
    getTodoCount().then((res) => {
      if (res.code === 0) setTodoCount(res.data.count);
    });
    if (timerRef.current) {
      clearInterval(timerRef.current);
    }
    timerRef.current = setInterval(() => getTodoCount().then((res) => {
      if (res.code === 0) setTodoCount(res.data.count);
    }), 60000);
    return () => {
      clearInterval(timerRef.current);
    }
  }, []);

  const fetchTodoCount = useCallback(async () => {
    const {data} = await getTodoCount();
    setTodoCount(data.count);
  }, []);


  return {
    permissionList,
    fetchPermissionList,
    currentUser,
    fetchCurrentUser,
    todoCount,
    fetchTodoCount
  };
}

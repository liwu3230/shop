import {useCallback, useState} from 'react';
import {getMainMenu} from '@/api/common';
import {MenuData} from '@/components/Layouts/Menu';

export default function useListModel() {

  const [menuList, setMenuList] = useState<MenuData[]>([]);
  const fetchMenuList = useCallback(async () => {
    const {data} = await getMainMenu();
    setMenuList(data);
  }, []);

  return {
    menuList,
    fetchMenuList,
  };
}

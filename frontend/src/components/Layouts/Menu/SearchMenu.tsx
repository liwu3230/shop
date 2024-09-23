import React, { useCallback, FC, CSSProperties, ChangeEvent } from 'react';
import { Input } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import { debounce } from 'lodash';
import { SEARCH_DEBOUNCE } from '@/constants';
import { MenuData } from './index';

interface searchMenuProps {
  menuTree: MenuData[];
  setMenuData: (menu: MenuData[]) => void;
  // setOpen: (ids: string[]) => void;
  reset: () => void;
}
const SearchMenu: FC<searchMenuProps> = (props) => {
  const findMenu = (val: string, menuTree: MenuData[]) => {
    const targetMenu: MenuData[] = [],
      parentIds: string[] = [];
    const getMatchMenu = (
      val: string,
      menuTree: MenuData[],
      parent: MenuData | null,
    ) => {
      for (let i = 0; i < menuTree.length; i++) {
        const item = menuTree[i];
        if (item.name.includes(val)) {
          const matchedMenu = parent || item;
          if (!parentIds.includes(`${matchedMenu.id}`)) {
            targetMenu.push(matchedMenu);
            parentIds.push(`${matchedMenu.id}`);
          }
        }
        getMatchMenu(val, item.children, parent || item);
      }
    };
    getMatchMenu(val, menuTree, null);
    return {
      menuData: targetMenu,
      parentIds,
    };
  };

  const doSearch = (e: ChangeEvent<HTMLInputElement>, menuTree: MenuData[]) => {
    const value = e.target.value.trim();
    if (value) {
      const data = findMenu(value, menuTree);
      props.setMenuData(data.menuData);
      // props.setOpen(data.parentIds);
    } else {
      props.reset();
    }
  };
  const handleSearch = useCallback(debounce(doSearch, SEARCH_DEBOUNCE), []);
  const onSearch = (e: ChangeEvent<HTMLInputElement>): void => {
    e.persist();
    handleSearch(e, props.menuTree);
  };
  const searchStyle: CSSProperties = {
    width: 'unset',
    margin: '0 6px',
    paddingTop: '12px',
  };
  return (
    <div style={searchStyle}>
      <Input
        placeholder="请输入关键字搜索"
        size="small"
        suffix={<SearchOutlined />}
        onChange={onSearch}
        allowClear
      />
    </div>
  );
};

export default SearchMenu;

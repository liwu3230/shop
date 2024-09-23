type PlainObject = Record<string, any>;
type UnknownObject = Record<string, unknown>;
type StrOrNum = string | number;

interface Location {
  backend: string;
}

interface OptionsItem {
  value: StrOrNum;
  label: string;
  type?: number;
  [propName: string]: unknown;
}

interface ChangeEvent extends Event {
  target: HTMLInputElement;
}

interface Page {
  currPage: number;
  list: Array<any>;
  pageSize: number;
  totalCount: number;
  totalPage: number;
}

type Nullable<T> = T | null;
type Recordable<T = any> = Record<string, T>;
type Indexable<T = any> = {
  [key: string]: T;
};

interface Fn<T = any, R = T> {
  (...arg: T[]): R;
}

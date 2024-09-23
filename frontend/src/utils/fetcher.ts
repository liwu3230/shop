import instance from '@/utils/http';
import { AxiosRequestConfig } from 'axios';

export const fetcher = async (config: Partial<AxiosRequestConfig>) => {
  return instance(config);
};

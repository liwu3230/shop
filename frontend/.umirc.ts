import {defineConfig} from '@umijs/max';
import {routes} from './src/routes';

const publicPath =
  process.env.NODE_ENV === 'production'
    ? 'https://yjz.mimr-china.com'
    : `http://localhost:${process.env.PORT}`;

export default defineConfig({
  favicons: [
    '/favicon.ico'
  ],
  // 启动按需加载
  // codeSplitting: {
  //     jsStrategy: 'granularChunks',
  // },
  historyWithQuery: {},
  model: {},
  // 取消默认的antd
  antd: {},
  // request: {},
  initialState: {},
  runtimePublicPath: {},
  mfsu: {},
  base: '/',
  routes,
  // 兼容 less 低版本变量
  lessLoader: {
    modifyVars: {
      '@text-color': 'rgba(0, 0, 0, 0.65)', // 文字颜色
      '@primary-color': '#3385ff', // 主色
      '@header-height': '46px',
      '@text-color-white': '#fff',
      '@background-dark': '#333333',
      '@background-deep-blue': '#001529',
      '@background-light': '#fff',
      '@ant-prefix': 'ant-cmdb',
    },
    javascriptEnabled: true,
  },
  // chainWebpack(config, args) {
  //     const fontRule = config.module.rule('fonts');
  //     fontRule.uses.clear();
  //     fontRule
  //         .use('file-loader')
  //         .loader('file-loader')
  //         .options({
  //             name: 'fonts/[name].[ext]',
  //             publicPath: publicPath,
  //         })
  //         .end();
  //
  //
  //     config.module
  //         .rule('images')
  //         .use('url-loader')
  //         .loader('url-loader')
  //         .options({
  //             limit: 4096, // 小于4kb将会被打包成 base64
  //             fallback: {
  //                 loader: 'file-loader',
  //                 options: {
  //                     name: 'images/[name].[ext]',
  //                     publicPath: publicPath,
  //                 },
  //             },
  //         });
  //
  // },


});

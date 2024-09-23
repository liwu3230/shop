/**
 * @description 生成占位的优化展示
 * @param groupNum 一行数目
 * @param items item集合
 */
export const genSearchPresentList = (
  groupNum: number,
  items: Record<string, unknown>[],
): { type: string; controls: Record<string, unknown>[] }[] => {
  const maxRow = Math.floor(items.length / groupNum);
  let res: { type: string; controls: Record<string, unknown>[] }[] = [];
  const maxLen = items.length % groupNum === 0 ? maxRow : maxRow + 1;
  for (let i = 0; i < maxLen; i++) {
    const controls = new Array(groupNum).fill(
      {
        type: 'grid',
        label: ' ',
        value: ' ',
      },
      0,
      groupNum,
    );
    res.push({
      type: 'group',
      controls,
    });
  }
  items.forEach((item, index) => {
    let row = Math.floor(index / groupNum);
    let idx = index % groupNum;
    res[row].controls[idx] = item;
  });
  return res;
};

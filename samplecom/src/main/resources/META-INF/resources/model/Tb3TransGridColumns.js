/**
 * 変遷グリッド定義
 */

let Tb3TransGridColumns = [];

$(function() {
    Tb3TransGridColumns = [
        Column.text('TRANS_ID', Messages['Tb3TransGrid.transId'], 90, 'primaryKey numbering', null),
        Column.text('TRANS_INFO', Messages['Tb3TransGrid.transInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb3TransGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

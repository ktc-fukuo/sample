/**
 * 変遷履歴グリッド定義
 */

let Tb3TransHisGridColumns = [];

$(function() {
    Tb3TransHisGridColumns = [
        Column.text('TRANS_ID', Messages['Tb3TransHisGrid.transId'], 90, 'primaryKey numbering', null),
        Column.text('TRANS_BN', Messages['Tb3TransHisGrid.transBn'], 90, 'primaryKey numbering', null),
        Column.text('TRANS_INFO', Messages['Tb3TransHisGrid.transInfo'], 300, '', null),
        Column.longText('RIYU_TX', Messages['Tb3TransHisGrid.riyuTx'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Tb3TransHisGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

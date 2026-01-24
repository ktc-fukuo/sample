/**
 * NOマスタグリッド定義
 */

let M04NoGridColumns = [];

$(function() {
    M04NoGridColumns = [
        Column.text('NOREF_NO', Messages['M04NoGrid.norefNo'], 90, 'primaryKey', null),
        Column.text('NOREF_MEI', Messages['M04NoGrid.norefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M04NoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

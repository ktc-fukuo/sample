/**
 * NOマスタグリッド定義
 */

let Mb4NoGridColumns = [];

$(function() {
    Mb4NoGridColumns = [
        Column.text('REF_NO', Messages['Mb4NoGrid.refNo'], 90, 'primaryKey', null),
        Column.text('REF_MEI', Messages['Mb4NoGrid.refMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Mb4NoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

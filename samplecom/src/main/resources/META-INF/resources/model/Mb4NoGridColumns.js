/**
 * NOマスタグリッド定義
 */

let Mb4NoGridColumns = [];

$(function() {
    Mb4NoGridColumns = [
        Column.text('NOREF_NO', Messages['Mb4NoGrid.norefNo'], 90, 'primaryKey', null),
        Column.text('NOREF_MEI', Messages['Mb4NoGrid.norefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Mb4NoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

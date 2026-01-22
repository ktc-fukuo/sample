/**
 * IDマスタグリッド定義
 */

let Mb4IdGridColumns = [];

$(function() {
    Mb4IdGridColumns = [
        Column.text('REF_ID', Messages['Mb4IdGrid.refId'], 90, 'primaryKey numbering', null),
        Column.text('REF_MEI', Messages['Mb4IdGrid.refMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Mb4IdGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

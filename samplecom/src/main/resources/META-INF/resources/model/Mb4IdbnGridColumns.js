/**
 * ID連番マスタグリッド定義
 */

let Mb4IdbnGridColumns = [];

$(function() {
    Mb4IdbnGridColumns = [
        Column.text('IDBN_ID', Messages['Mb4IdbnGrid.idbnId'], 90, 'primaryKey numbering', null),
        Column.text('IDBN_BN', Messages['Mb4IdbnGrid.idbnBn'], 90, 'primaryKey numbering', null),
        Column.text('IDBN_NO', Messages['Mb4IdbnGrid.idbnNo'], 90, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Mb4IdbnGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

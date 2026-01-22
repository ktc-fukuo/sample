/**
 * IDマスタグリッド定義
 */

let Mb4IdGridColumns = [];

$(function() {
    Mb4IdGridColumns = [
        Column.text('IDREF_ID', Messages['Mb4IdGrid.idrefId'], 90, 'primaryKey numbering', null),
        Column.text('IDREF_MEI', Messages['Mb4IdGrid.idrefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Mb4IdGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

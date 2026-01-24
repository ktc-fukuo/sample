/**
 * 子グリッド定義
 */

let T01KoGridColumns = [];

$(function() {
    T01KoGridColumns = [
        Column.text('OYA_ID', Messages['T01KoGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T01KoGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('KO_INFO', Messages['T01KoGrid.koInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01KoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

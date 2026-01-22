/**
 * 子グリッド定義
 */

let Tb1KoGridColumns = [];

$(function() {
    Tb1KoGridColumns = [
        Column.text('OYA_ID', Messages['Tb1KoGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['Tb1KoGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('KO_INFO', Messages['Tb1KoGrid.koInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb1KoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

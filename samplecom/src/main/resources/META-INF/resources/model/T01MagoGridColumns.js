/**
 * 孫グリッド定義
 */

let T01MagoGridColumns = [];

$(function() {
    T01MagoGridColumns = [
        Column.text('OYA_ID', Messages['T01MagoGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T01MagoGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('MAGO_BN', Messages['T01MagoGrid.magoBn'], 90, 'primaryKey numbering', null),
        Column.text('MAGO_INFO', Messages['T01MagoGrid.magoInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01MagoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

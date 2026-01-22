/**
 * 子なしグリッド定義
 */

let Tb1DinksGridColumns = [];

$(function() {
    Tb1DinksGridColumns = [
        Column.text('OYA_ID', Messages['Tb1DinksGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['Tb1DinksGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('DINKS_INFO', Messages['Tb1DinksGrid.dinksInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb1DinksGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

/**
 * 再帰グリッド定義
 */

let T04SaikiGridColumns = [];

$(function() {
    T04SaikiGridColumns = [
        Column.text('SAIKI_ID', Messages['T04SaikiGrid.saikiId'], 90, 'primaryKey numbering', null),
        Column.text('SAIKI_MEI', Messages['T04SaikiGrid.saikiMei'], 300, 'notblank', null),
        Column.refer('IDREF_ID', Messages['T04SaikiGrid.idrefId'], 90, '', 'IDREF_MEI'),
        Column.refer('CDREF_CD', Messages['T04SaikiGrid.cdrefCd'], 90, '', 'CDREF_MEI'),
        Column.refer('NOREF_NO', Messages['T04SaikiGrid.norefNo'], 90, '', 'NOREF_MEI'),
        Column.text('IDBN_ID', Messages['T04SaikiGrid.idbnId'], 90, '', null),
        Column.refer('IDBN_BN', Messages['T04SaikiGrid.idbnBn'], 90, '', 'IDBN_NO'),
        Column.refer('OYA_SAIKI_ID', Messages['T04SaikiGrid.oyaSaikiId'], 90, '', 'OYA_SAIKI_MEI'),
        Column.cell('UPDATE_TS', Messages['T04SaikiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

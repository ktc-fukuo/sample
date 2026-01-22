/**
 * 再帰グリッド定義
 */

let Tb4SaikiGridColumns = [];

$(function() {
    Tb4SaikiGridColumns = [
        Column.text('SAIKI_ID', Messages['Tb4SaikiGrid.saikiId'], 90, 'primaryKey numbering', null),
        Column.text('SAIKI_MEI', Messages['Tb4SaikiGrid.saikiMei'], 300, 'notblank', null),
        Column.refer('IDREF_ID', Messages['Tb4SaikiGrid.idrefId'], 90, '', 'IDREF_MEI'),
        Column.refer('CDREF_CD', Messages['Tb4SaikiGrid.cdrefCd'], 90, '', 'CDREF_MEI'),
        Column.refer('NOREF_NO', Messages['Tb4SaikiGrid.norefNo'], 90, '', 'NOREF_MEI'),
        Column.text('IDBN_ID', Messages['Tb4SaikiGrid.idbnId'], 90, '', null),
        Column.refer('IDBN_BN', Messages['Tb4SaikiGrid.idbnBn'], 90, '', 'IDBN_NO'),
        Column.refer('OYA_SAIKI_ID', Messages['Tb4SaikiGrid.oyaSaikiId'], 90, '', 'OYA_SAIKI_MEI'),
        Column.cell('UPDATE_TS', Messages['Tb4SaikiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

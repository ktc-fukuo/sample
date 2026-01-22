/**
 * 再帰グリッド定義
 */

let Tb4SaikiGridColumns = [];

$(function() {
    Tb4SaikiGridColumns = [
        Column.text('SAIKI_ID', Messages['Tb4SaikiGrid.saikiId'], 90, 'primaryKey numbering', null),
        Column.text('SAIKI_MEI', Messages['Tb4SaikiGrid.saikiMei'], 300, 'notblank', null),
        Column.refer('REF_ID', Messages['Tb4SaikiGrid.refId'], 90, '', 'REF_MEI'),
        Column.refer('REF_CD', Messages['Tb4SaikiGrid.refCd'], 90, '', 'REF_MEI'),
        Column.refer('REF_NO', Messages['Tb4SaikiGrid.refNo'], 90, '', 'REF_MEI'),
        Column.text('REF_BN', Messages['Tb4SaikiGrid.refBn'], 90, '', null),
        Column.refer('EX_REF_ID', Messages['Tb4SaikiGrid.exRefId'], 90, '', 'EX_REF_MEI'),
        Column.text('EX_REF_BN', Messages['Tb4SaikiGrid.exRefBn'], 90, '', null),
        Column.refer('OYA_SAIKI_ID', Messages['Tb4SaikiGrid.oyaSaikiId'], 90, '', 'OYA_SAIKI_MEI'),
        Column.cell('UPDATE_TS', Messages['Tb4SaikiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

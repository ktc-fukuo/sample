/**
 * 共生グリッド定義
 */

let Tb6KyoseiGridColumns = [];

$(function() {
    Tb6KyoseiGridColumns = [
        Column.text('KYOSEI_ID', Messages['Tb6KyoseiGrid.kyoseiId'], 90, 'primaryKey numbering', null),
        Column.refer('PREV_ID', Messages['Tb6KyoseiGrid.prevId'], 90, 'notblank', ''),
        Column.text('PREV_INFO', Messages['Tb6KyoseiGrid.prevInfo'], 300, '', null),
        Column.refer('ORG_ID', Messages['Tb6KyoseiGrid.orgId'], 90, 'notblank', ''),
        Column.text('ORG_INFO', Messages['Tb6KyoseiGrid.orgInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6KyoseiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

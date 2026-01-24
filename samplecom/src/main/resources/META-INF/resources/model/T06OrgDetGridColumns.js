/**
 * 起源明細グリッド定義
 */

let T06OrgDetGridColumns = [];

$(function() {
    T06OrgDetGridColumns = [
        Column.text('ORG_ID', Messages['T06OrgDetGrid.orgId'], 90, 'primaryKey numbering', null),
        Column.text('ORG_BN', Messages['T06OrgDetGrid.orgBn'], 90, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T06OrgDetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T06OrgDetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

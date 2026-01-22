/**
 * 寄生グリッド定義
 */

let Tb6Kisei2GridColumns = [];

$(function() {
    Tb6Kisei2GridColumns = [
        Column.text('KISEI2_ID', Messages['Tb6Kisei2Grid.kisei2Id'], 90, 'primaryKey numbering', null),
        Column.text('ORG_INFO', Messages['Tb6Kisei2Grid.orgInfo'], 300, '', null),
        Column.refer('ORG_ID', Messages['Tb6Kisei2Grid.orgId'], 90, '', ''),
        Column.cell('UPDATE_TS', Messages['Tb6Kisei2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

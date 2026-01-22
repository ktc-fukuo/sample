/**
 * 複合２グリッド定義
 */

let Tb5Comp2GridColumns = [];

$(function() {
    Tb5Comp2GridColumns = [
        Column.refer('REF1_ID', Messages['Tb5Comp2Grid.ref1Id'], 90, 'primaryKey numbering', 'REF1_MEI'),
        Column.refer('REF2_ID', Messages['Tb5Comp2Grid.ref2Id'], 90, 'primaryKey numbering', 'REF2_MEI'),
        Column.refer('REF3_ID', Messages['Tb5Comp2Grid.ref3Id'], 90, 'primaryKey', 'REF3_MEI'),
        Column.date('TEKIYO_BI', Messages['Tb5Comp2Grid.tekiyoBi'], 90, 'primaryKey', Slick.Formatters.Extends.Date),
        Column.text('COMP2_INFO', Messages['Tb5Comp2Grid.comp2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb5Comp2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

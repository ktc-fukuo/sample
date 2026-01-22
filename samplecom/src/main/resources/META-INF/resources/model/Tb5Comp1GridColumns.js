/**
 * 複合１グリッド定義
 */

let Tb5Comp1GridColumns = [];

$(function() {
    Tb5Comp1GridColumns = [
        Column.refer('REF1_ID', Messages['Tb5Comp1Grid.ref1Id'], 90, 'primaryKey', 'REF1_MEI'),
        Column.refer('REF2_ID', Messages['Tb5Comp1Grid.ref2Id'], 90, 'primaryKey', 'REF2_MEI'),
        Column.text('COMP1_INFO', Messages['Tb5Comp1Grid.comp1Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb5Comp1Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

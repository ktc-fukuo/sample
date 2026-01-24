/**
 * 他生２グリッド定義
 */

let T12Tasho2GridColumns = [];

$(function() {
    T12Tasho2GridColumns = [
        Column.text('TASHO2_ID', Messages['T12Tasho2Grid.tasho2Id'], 90, 'primaryKey numbering', null),
        Column.refer('KOHO3_ID', Messages['T12Tasho2Grid.koho3Id'], 90, '', ''),
        Column.cell('UPDATE_TS', Messages['T12Tasho2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

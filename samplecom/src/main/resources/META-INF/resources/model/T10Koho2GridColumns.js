/**
 * 候補２グリッド定義
 */

let T10Koho2GridColumns = [];

$(function() {
    T10Koho2GridColumns = [
        Column.text('KOHO2_ID', Messages['T10Koho2Grid.koho2Id'], 90, 'primaryKey numbering', null),
        Column.text('KOHO2_INFO', Messages['T10Koho2Grid.koho2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T10Koho2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

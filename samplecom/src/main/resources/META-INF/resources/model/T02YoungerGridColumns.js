/**
 * 弟グリッド定義
 */

let T02YoungerGridColumns = [];

$(function() {
    T02YoungerGridColumns = [
        Column.text('BRO_ID', Messages['T02YoungerGrid.broId'], 90, 'primaryKey numbering', null),
        Column.text('YOUNGER_INFO', Messages['T02YoungerGrid.youngerInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02YoungerGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

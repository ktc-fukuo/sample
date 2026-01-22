/**
 * 寄生グリッド定義
 */

let Tb6KiseiGridColumns = [];

$(function() {
    Tb6KiseiGridColumns = [
        Column.text('KISEI_ID', Messages['Tb6KiseiGrid.kiseiId'], 90, 'primaryKey numbering', null),
        Column.text('PREV_INFO', Messages['Tb6KiseiGrid.prevInfo'], 300, '', null),
        Column.refer('PREV_ID', Messages['Tb6KiseiGrid.prevId'], 90, '', ''),
        Column.cell('UPDATE_TS', Messages['Tb6KiseiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

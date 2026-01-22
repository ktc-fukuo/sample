/**
 * 前世明細グリッド定義
 */

let Tb6PrevDetGridColumns = [];

$(function() {
    Tb6PrevDetGridColumns = [
        Column.text('PREV_ID', Messages['Tb6PrevDetGrid.prevId'], 90, 'primaryKey numbering', null),
        Column.text('PREV_BN', Messages['Tb6PrevDetGrid.prevBn'], 90, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['Tb6PrevDetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6PrevDetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

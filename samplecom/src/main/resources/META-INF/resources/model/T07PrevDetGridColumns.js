/**
 * 前世明細グリッド定義
 */

let T07PrevDetGridColumns = [];

$(function() {
    T07PrevDetGridColumns = [
        Column.text('PREV_ID', Messages['T07PrevDetGrid.prevId'], 90, 'primaryKey numbering', null),
        Column.text('PREV_BN', Messages['T07PrevDetGrid.prevBn'], 90, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T07PrevDetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T07PrevDetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

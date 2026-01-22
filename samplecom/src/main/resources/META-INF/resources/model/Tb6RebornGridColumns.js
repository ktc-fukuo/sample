/**
 * 転生グリッド定義
 */

let Tb6RebornGridColumns = [];

$(function() {
    Tb6RebornGridColumns = [
        Column.text('REBORN_ID', Messages['Tb6RebornGrid.rebornId'], 90, 'primaryKey numbering', null),
        Column.text('PREV_INFO', Messages['Tb6RebornGrid.prevInfo'], 300, '', null),
        Column.refer('PREV_ID', Messages['Tb6RebornGrid.prevId'], 90, 'notblank', ''),
        Column.cell('UPDATE_TS', Messages['Tb6RebornGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

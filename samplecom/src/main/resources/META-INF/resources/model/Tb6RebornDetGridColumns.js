/**
 * 転生明細グリッド定義
 */

let Tb6RebornDetGridColumns = [];

$(function() {
    Tb6RebornDetGridColumns = [
        Column.text('REBORN_ID', Messages['Tb6RebornDetGrid.rebornId'], 90, 'primaryKey numbering', null),
        Column.text('REBORN_BN', Messages['Tb6RebornDetGrid.rebornBn'], 90, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['Tb6RebornDetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6RebornDetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

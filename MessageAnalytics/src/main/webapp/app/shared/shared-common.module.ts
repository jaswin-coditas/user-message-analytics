import { NgModule } from '@angular/core';

import { MessageAnalyticsSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [MessageAnalyticsSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [MessageAnalyticsSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class MessageAnalyticsSharedCommonModule {}

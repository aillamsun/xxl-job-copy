package com.xxl.job.admin.core.jobbean;

import com.xxl.job.admin.core.trigger.XxlJobTrigger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * http job bean 所有任务触发 自动 或者 admin 手动触发  都会经过该类
 * “@DisallowConcurrentExecution” diable concurrent, thread size can not be only one, better given more
 * @QuartzJobBean
 * @author xuxueli 2015-12-17 18:20:34
 */
//@DisallowConcurrentExecution
public class RemoteHttpJobBean extends QuartzJobBean {
	private static Logger logger = LoggerFactory.getLogger(RemoteHttpJobBean.class);

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		// load jobId
		JobKey jobKey = context.getTrigger().getJobKey();
		Integer jobId = Integer.valueOf(jobKey.getName());

		// trigger 触发任务
		XxlJobTrigger.trigger(jobId);
	}

}
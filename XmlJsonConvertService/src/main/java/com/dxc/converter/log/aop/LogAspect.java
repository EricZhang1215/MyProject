package com.dxc.converter.log.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dxc.converter.log.annotation.OperationLogDetail;
import com.dxc.converter.log.model.OperationLog;

@Aspect
@Component
public class LogAspect {

	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut("@annotation(com.dxc.converter.log.annotation.OperationLogDetail)")
	public void operationLog() {
	}

	/**
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("operationLog()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object res = null;
		long time = System.currentTimeMillis();
		try {
			res = joinPoint.proceed();
			time = System.currentTimeMillis() - time;
			return res;
		} finally {
			try {
				addOperationLog(joinPoint, res, time);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * add operation log
	 * 
	 * @param joinPoint
	 * @param res
	 * @param time
	 */
	private void addOperationLog(JoinPoint joinPoint, Object res, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		OperationLog operationLog = new OperationLog();
		operationLog.setRunTime(time);
		operationLog.setCreateTime(new Date());
		operationLog.setMethod(signature.getDeclaringTypeName() + "." + signature.getName());
		OperationLogDetail annotation = signature.getMethod().getAnnotation(OperationLogDetail.class);
		if (annotation != null) {
			operationLog.setDetail(annotation.detail());
			operationLog.setLevel(annotation.level());
			operationLog.setOperationType(annotation.operationType().getValue());
			operationLog.setOperationUnit(annotation.operationUnit().getValue());
		}
		// TODO Save to DB
		logger.info("----{}", operationLog.toString());
	}

}

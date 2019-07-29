package com.minsait.onesait.h3.sentinel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

@Configuration
public class FlowRules {

	private static final String RESOURCE_PRINCIPAL = "principalInfo";

	@Bean
	private static void initFlowQpsRule() {
		final List<FlowRule> rules = new ArrayList<>();
		final FlowRule rule1 = new FlowRule();
		rule1.setResource(RESOURCE_PRINCIPAL);
		rule1.setCount(2);
		rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
		rule1.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
		rules.add(rule1);
		FlowRuleManager.loadRules(rules);
	}

}

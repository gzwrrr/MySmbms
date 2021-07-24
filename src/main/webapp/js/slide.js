window.addEventListener('load', function() {
	//获取元素
	var leftb = document.querySelector('.left');
	var rightb = document.querySelector('.right');
	var box = document.querySelector('#slideshow-box');
	var imgs = box.querySelector('.imgs');
	var imgt = imgs.querySelectorAll('li');
	//自动翻页函数
	var timeone = setInterval(function() {
		rightf();
	}, 3000);
	//左右按钮的出现
	box.addEventListener('mouseover', function() {
		leftb.style.display = 'block';
		rightb.style.display = 'block';
		//移入时清除定时器
		clearInterval(timeone);
		timeone = null;
	})

	//左右按钮的消失
	box.addEventListener('mouseout', function() {
		leftb.style.display = 'none';
		rightb.style.display = 'none';
		//恢复定时器
		clearInterval(timeone);
		timeone = setInterval(function() {
			rightf();
		}, 3000)
	})
	//动态生成小圆圈，小圈圈模块
	var list = box.querySelector('.list');
	for (var i = 0; i < imgs.children.length; i++) {
		//创建li，加入ul中
		var li = document.createElement('li');
		list.appendChild(li);
		//给小圈圈添加类名
		li.setAttribute('index', i);
		//排他思想，实现点击小圆圈，变色
		li.addEventListener('click', colors);
		//经过小圆圈，切换图片
		li.addEventListener('mouseenter', jump);
	}
	//一开始第二个亮
	list.children[1].className = 'change';
	//变色函数 
	function colors() {
		//把所有的小圆圈变白
		for (var i = 0; i < list.children.length; i++) {
			list.children[i].className = '';
		}
		//给图片对应的小圆圈上色
		var index = this.getAttribute('index');
		list.children[index].className = 'change';
	}
	//跳转函数
	function jump() {
		var index = this.getAttribute('index');
		var now = num.indexOf('two');
		//计算经过点与当前点的距离
		var dif = Math.max(index, now) - Math.min(index, now);
		// console.log(dis);
		if (index > now) {
			while (dif--) {
				rightf();
			}
		} else {
			while (dif--) {
				leftf();
			}
		}
	}
	//小圆圈跟随着图片移动
	var j = 1;

	function colort() {
		for (var i = 0; i < list.children.length; i++) {
			list.children[i].className = '';
		}
		if (j >= 6) {
			j = 0;
		} else if (j < 0) {
			j = 5;
		}
		list.children[j].className = 'change';
	}
	//翻页模块
	var num = ['one', 'two', 'three', 'four', 'five', 'six'];
	//右翻页
	rightb.addEventListener('click', rightf);

	function rightf() {
		//把数组的最后一个添加到第一个
		num.unshift(num[5]);
		//删除最后一个
		num.pop();
		//重新给li添加类名
		for (var i = 0; i < num.length; i++) {
			imgt[i].setAttribute('class', num[i]);
		}
		//通过这个全局变量来让小圆圈的颜色一起变化
		j++;
		colort();
	}
	//左翻页
	leftb.addEventListener('click', leftf)

	function leftf() {
		num.push(num[0]);
		num.shift();
		for (var i = 0; i < num.length; i++) {
			imgt[i].setAttribute('class', num[i]);
		}
		j--;
		colort();
	}
	//点击图片实现翻页,这里我是通过在左右两边添加一个盒子来实现的
	var rights = document.querySelector('.rights');
	rights.addEventListener('click', function() {
		rightf();
	})
	var lefts = document.querySelector('.lefts');
	lefts.addEventListener('click', function() {
		leftf();
	})
})

Function.prototype.apply=function(obj,args){obj=obj==undefined?window:Object(obj);var i=0,ary=[],str;if(args){for(var len=args.length;i<len;i++){ary[i]="args["+i+"]"}}obj._apply=this;str="obj._apply("+ary.join(",")+")";try{return eval(str)}catch(e){}};
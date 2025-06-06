class Solution:
    def search(self, pat, txt):
        st=0
        res=[]
        while((pos:=txt.find(pat,st))!=-1):
            res.append(pos+1)
            st=pos+1
        return res
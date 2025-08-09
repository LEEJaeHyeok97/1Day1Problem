# 도시 이름 검색 시맛집 해당 도시의 맛집 게시물들을 조회
# 제이지가 로직 개선을 위해 캐시를 적용
# 캐시 크기 선정을 위한 캐시 크기 별 실행 시간 측정 프로그램을 작성
# 0<=cachesize는<=30
# 도시 이름은 대소문 구분x 영문으로만 구성
# 배열을 처리할 때 '총 실행시간'을 출력
# 캐시 교체 알고리즘은 LRU를 사용 - cache hit 시 1 cache miss 시 5(실행시간)
def solution(cacheSize, cities):
    cache = []
    if cacheSize == 0:
        return len(cities) * 5
    
    cnt = 0
    for city in cities:
        c = city.lower()
        if c in cache:
            cnt += 1
            cache.pop(cache.index(c))
            cache.append(c)
        else:
            if len(cache) == cacheSize:
                cache = cache[1:]
                cnt += 5
                cache.append(c)
            else:
                cnt += 5
                cache.append(c)
            
    
    answer = cnt
    return answer





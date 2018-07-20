import org.springframework.cloud.contract.spec.Contract;

/**
 * @Author: yangjianguang
 * @Date: 2018/6/20
 */
Contract.make {
    request {
        method 'GET'
        url '/provider2'
    }
    response {
        status 200
        body([
                "id":$(producer(regex('[0-9]{1,3}'))),
                "provider": "provider2"
        ])
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}
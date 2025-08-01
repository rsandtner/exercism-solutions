local Hamming = {}

local distance = function(a, b)
    local diff = 0
    for i = 1, #a do
        if a:sub(i, i) ~= b:sub(i, i) then
            diff = diff + 1
        end
    end

    return diff
end

function Hamming.compute(a,b)

    local length = #a
    if length ~= #b then
        return -1
    end

    return distance(a, b)
end


return Hamming

